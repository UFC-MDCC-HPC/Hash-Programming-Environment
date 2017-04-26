/*import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

import hpcshelf.certification.util.CertifierConstants;*/
using System;
using System.Xml.Schema;
using System.IO;

using System.Xml;

using br.ufc.pargo.hpe.backend.DGAC.TCOL.util;
namespace br.ufc.pargo.hpe.backend.DGAC.TCOL.grammar{



public class CertifierOrchestrationValidator {

	//private String archXSD = CertifierConstants.ARCH_XSD;
		private String orchesXSD = CertifierConstants.ORCHESTRATION_XSD;
		private String xmlValidate = CertifierConstants.ORCHESTRATION_FILE_TEST;
	
	/*public bool validateXMLArchitecture(String xmlFile){
		System.out.println(xmlFile);
		System.out.println(archXSD);
		bool result = true;
		try {
			URL schemaFile = this.getClass().getResource(archXSD);
			Source xmlFileSrc = new StreamSource(new File(xmlFile));
			SchemaFactory schemaFactory = SchemaFactory
					.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = schemaFactory.newSchema(schemaFile);
			Validator validator = schema.newValidator();
			validator.validate(xmlFileSrc);
		} catch (MalformedURLException e) {
			result = false;
			e.printStackTrace();
		} catch (SAXException e) {
			result = false;
			e.printStackTrace();
		} catch (IOException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}*/ private static void Validate(String filename, XmlSchemaSet schemaSet)
		{
			Console.WriteLine();
			Console.WriteLine("\r\nValidating XML file {0}...", filename.ToString());

			XmlSchema compiledSchema = null;

			foreach (XmlSchema schema in schemaSet.Schemas())
			{
				compiledSchema = schema;
			}

			XmlReaderSettings settings = new XmlReaderSettings();
			settings.Schemas.Add(compiledSchema);
			settings.ValidationEventHandler += new ValidationEventHandler(ValidationCallBack);
			settings.ValidationType = ValidationType.Schema;

			//Create the schema validating reader.
			XmlReader vreader = XmlReader.Create(filename, settings);

			while (vreader.Read()) { }

			//Close the reader.
			vreader.Close();
		}

		//Display any warnings or errors.
		private static void ValidationCallBack(object sender, ValidationEventArgs args)
		{
			if (args.Severity == XmlSeverityType.Warning)
				Console.WriteLine("\tWarning: Matching schema not found.  No validation occurred." + args.Message);
			else
				Console.WriteLine("\tValidation error: " + args.Message);

		}
	public bool validateXMLOrchestration(String xmlFile){

			//Load the XmlSchemaSet.
			XmlSchemaSet schemaSet = new XmlSchemaSet();
			schemaSet.Add("urn:Certifier_Orchestration", orchesXSD);

			//Validate the file using the schema stored in the schema set.
			//Any elements belonging to the namespace "urn:cd-schema" generate
			//a warning because there is no schema matching that namespace.
			Validate(xmlValidate, schemaSet);

			Console.ReadLine();
			return true;
			/*
			bool result = true;
		try {
			Uri schemaFile = this.GetType()..getResource(orchesXSD);
			Source xmlFileSrc = new StreamSource(new File(xmlFile));
			SchemaFactory schemaFactory = SchemaFactory
					.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = schemaFactory.newSchema(schemaFile);
			Validator validator = schema.newValidator();
			validator.validate(xmlFileSrc);
		} catch (MalformedURLException e) {
			result = false;
			e.printStackTrace();
		} catch (SAXException e) {
			result = false;
			e.printStackTrace();
		} catch (IOException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}*/
		}}}
