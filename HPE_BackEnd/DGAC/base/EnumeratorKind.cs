/*=============================================================
(c) all rights reserved
================================================================*/
using System;
using br.ufc.hpe.basic;

namespace br.ufc.hpe.kinds{
     public interface IEnumeratorKind : IUnit {
       int getValueAtIndex(int ix);
       int[] getPermutation();
       int N {get;set;}
       bool undefinedN();
       string V { get; set; }
       bool undefinedV();
   }
   
   public abstract class Enumerator : Unit, IEnumeratorKind {

      private int[] permutation = null;
      private int N_ = 0;

      public Enumerator() { }

      public Enumerator(int N) {
            this.N = N;
      }
      
      protected abstract void permute();
      
      protected void permute(int x, int y) {
         int aux = permutation[x];
         permutation[x] = permutation[y];
         permutation[y] = aux;
      }

      public int N
      {
          set
          {
              N_ = value;
              permutation = new int[N];
              for (int i = 0; i < N; i++)
              {
                  permutation[i] = i;
              }
              permute();
          }
          get
          {
              if (!this.undefinedN())
                  return N_;
              else
                  throw new Exception("undefined N (Enumerator.N).");
          }
      }

      public bool undefinedN()
      {
          return this.N_ == 0;
      }

       public int getValueAtIndex(int index)
      {
         if (!this.undefinedN()) {
            if (permutation.Length < index)         
               return permutation[index];
            else {
               throw new Exception("Index does not exist in permutation (EnumeratorKind.getValueAtIndex).");
            }
         } else {
            throw new Exception("undefined N (Enumerator.getValueAtIndex).");
         }
      }
      
      public int[] getPermutation() {
          return (int[]) permutation.Clone(); 
      }

      private string V_ = null;

      public string V
      {
          set
          {
              V_ = value;
          }
          get
          {
              if (!this.undefinedV())
                  return V_;
              else
                  throw new Exception("undefined variable name (Enumerator.V).");
          }
      }

      public bool undefinedV()
      {
          return this.V_ == null;
      }


   }
   
   
}
