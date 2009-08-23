/*=============================================================
(c) all rights reserved
================================================================*/
using System;
using hpe.basic;

namespace hpe.kinds{
     interface IEnumeratorKind {
       int N {get;set;}                     // Number of replicas
       string IndexName {set;}              // Name of the enumerator
       void permute(int x, int y);
       int getValueAtIndex(int ix);
       int[] getPermutation();
   }
   
   public abstract class EnumeratorUnitImpl {
      private int[] permutation = null;
      private int N_;
      
      EnumeratorUnitImpl() {
            
      }
      
      public int N {
         set {
               if (permutation == null) {
	               N_ = value;
	               permutation = new int[N];
	               for (int i=0; i<N; i++) {
	                  permutation[i] = i;
	               } 
               } else {
                  throw new Exception("N is already set (EnumeratorKind.setN).");
               }
             }
         get {return N_;}
      }
      
      public int[] getPermutation() {
         return permutation;
      }
      
      public int getValueAtIndex(int index) {
         if (permutation != null) {
            if (permutation.Length < index)         
               return permutation[index];
            else {
               throw new Exception("Index does not exist in permutation (EnumeratorKind.getValueAtIndex).");
            }
         } else {
            throw new Exception("N not set (EnumeratorKind.getValueAtIndex).");
         }
      }
   }
   
   
}
