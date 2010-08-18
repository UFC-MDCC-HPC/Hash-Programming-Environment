package linearsystems.qualifier;

qualifier Library 
{
  enumerator N : Enumerator;

  unit library_unit {
    slice i from N.index;    
  }
   
}