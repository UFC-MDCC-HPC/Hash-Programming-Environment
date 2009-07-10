using System;
using System.Collections.Generic;
using System.Text;

namespace DGAC.database
{
    class EnumeratorSplit
    {
        private string id_enumerator;

        public string Id_enumerator
        {
            get { return id_enumerator; }
            set { id_enumerator = value; }
        }

        private int id_split;

        public int Id_split
        {
            get { return id_split; }
            set { id_split = value; }
        }

        private string id_enumerator_split;

        public string Id_enumerator_split
        {
            get { return id_enumerator_split; }
            set { id_enumerator_split = value; }
        }

        private int id_abstract;

        public int Id_abstract
        {
            get { return id_abstract; }
            set { id_abstract = value; }
        }

        private int id_total_split;

        public int Id_total_split
        {
            get { return id_total_split; }
            set { id_total_split = value; }
        }


        // This function is reponsible to distribute ranks of enumerators among split enumerators.
        internal int mapSplitEnumerationValue(int re_Value,
                                              IDictionary<string, int> enumeratorCardinality,
                                              IDictionary<string, int> enumeratorCardinality_prime)
        {
            int re_Value_final = -1;
            EnumeratorSplitDAO esplitdao = new EnumeratorSplitDAO();
            IList<EnumeratorSplit> sList = esplitdao.listSplits(this.Id_abstract, this.Id_enumerator);
            int i = 0, count = 0, k;
            foreach (EnumeratorSplit es in sList)
            {
                if (this.Id_split == es.Id_split)
                {
                    re_Value_final = count + re_Value;
                }
                enumeratorCardinality.TryGetValue(es.Id_enumerator_split, out k);
                count += k;
                i++;
            }
            enumeratorCardinality_prime.Add(this.Id_enumerator, count);

            if (i != this.Id_total_split)
            {
            }

            return re_Value_final;
        }
    }
}