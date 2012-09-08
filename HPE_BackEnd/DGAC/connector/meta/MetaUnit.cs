/*=============================================================
(c) 2012 by Juliano Efson Sales
www.mdcc.ufc.br
================================================================*/

using System;
using System.Collections.Generic;

using br.ufc.pargo.hpe.connector.config;

using br.ufc.pargo.hpe.basic;

namespace br.ufc.pargo.hpe.connector.meta {
   
   //Classe que representa os metadados das unidades de um componente hash.
   public class MetaUnit : MetaHashEntity {
      
      protected int index;
      public int Index {
         get {return index;}
         set {index = value;}
      }
      
      protected int split;
      public int Split {
         get {return split;}
         set {split = value;}
      }
      
      protected bool parallel;
      public bool Parallel {
         get{return parallel;}
         set{parallel = value;}
      }
      
      public override Object Entity {
         get {return entity;}
         set {
            entity = value;
            linkEntities();
         }         
      }
      
      //Lista de metadados das ações vinculadas à unidade.
      protected List<MetaAction> actions;
      public List<MetaAction> Actions {
         get {return actions;}
         set {actions = value;}
      }
      
      protected List<Condition> conditions;
      public List<Condition> Conditions {
         get {return conditions;}
         set {conditions = value;}
      }
      
      //Lista da fatias dos componente aninhados que participam desta unidade.
      protected List<MetaSlice> slices;
      public List<MetaSlice> Slices {
         get {return slices;}
         set {slices = value;}
      }
      
      protected IConfigurationManager configManager;
      public IConfigurationManager ConfigManager {
         get {return configManager;}
         set {configManager = value;}
      }
      
      //protocolo de valição da unidade.
      //TODO ALTO definir representação e forma de execução da validação.
      protected string validationProtocol;
      
      public void AddAction(MetaAction a) {
         if(actions == null) {
            actions = new List<MetaAction>();
         }
         
         a.Father = this;
         actions.Add(a);
      }
      
      public void AddSlice(MetaSlice slice) {
         if(slices == null) {
            slices = new List<MetaSlice>();
         }
         
         //o Father da fatia deve ser o seu hashcomponent.
         slices.Add(slice);
      }
      
      public MetaUnit() 
	  {
         this.parallel = true;
         this.split = 1;
      }
      
      public void linkEntities() {
         
         System.Console.WriteLine(Name);
         System.Console.WriteLine(Entity.ToString());
         
         if(slices != null) {
            IUnit unit = (IUnit) entity;
            
            foreach(MetaSlice slice in slices) {
               slice.Unit.Entity = unit.Slice[slice.Inner];
            }
         }
         
         GenerateDelegates();
      }
      
      /*
      Gera os delegates das ações e fatias.
      */
      public void GenerateDelegates() {
         
         if(actions != null) {
            foreach(MetaAction a in actions) {
               if(a.IsNative) {

                  a.Entity = (MetaAction.DAction) Delegate.CreateDelegate(typeof(MetaAction.DAction), Entity, a.Name);
               }
            }
         }
         
         if(conditions != null) {
            foreach(Condition c in conditions) {
               //c.Entity = (Condition.DCondition) Delegate.CreateDelegate(typeof(Condition.DCondition), Entity, method);
            }
         }
         
         if(slices != null && slices.Count > 0) {
            foreach(MetaSlice s in slices) {
               s.Unit.GenerateDelegates();
            }
         }
      }
   }
}
