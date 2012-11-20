/*=============================================================
(c) 2012 by Juliano Efson Sales
www.mdcc.ufc.br
================================================================*/

namespace br.ufc.pargo.hpe.connector.load {
   
   using System;
   using System.Xml;
   using System.Xml.Schema;
   
   public class XmlFormatValidator {
      protected int ErrorsCount = 0;
      
      protected string ErrorMessage = "";
      
      public bool IsValid(string xsdPath, string xmlPath) {
         ErrorMessage = "";

         XmlReaderSettings settings = new XmlReaderSettings();
         settings.Schemas.Add(null, xsdPath);
         settings.ValidationType = ValidationType.Schema;
         settings.ValidationEventHandler += new ValidationEventHandler(settingsValidationEventHandler);
         
         XmlReader xml = XmlReader.Create(xmlPath, settings);
         
         while (xml.Read()) { }
         
         if (ErrorsCount > 0)
          {
            return false;
         }
         
         return true;
      }

      protected void settingsValidationEventHandler(object sender, ValidationEventArgs e)
      {
         if (e.Severity == XmlSeverityType.Warning)
          {
            System.Diagnostics.Debug.Write("WARNING: ");
            System.Diagnostics.Debug.WriteLine(e.Message);
         }
         else if (e.Severity == XmlSeverityType.Error)
          {
            System.Diagnostics.Debug.Write("ERROR: ");
            System.Diagnostics.Debug.WriteLine(e.Message);
            ErrorsCount++;
         }
      }
   }
}

