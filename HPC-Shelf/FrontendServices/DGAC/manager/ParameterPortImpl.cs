using System;
using gov.cca.ports;

namespace br.ufc.hpe.backend.DGAC
{
	public class ParameterPortImpl : ParameterPort
	{
		public ParameterPortImpl()
		{
			
		}

		#region ParameterPort implementation
		public string readTitle ()
		{
			throw new NotImplementedException ();
		}

		public string[] readGroupNames ()
		{
			throw new NotImplementedException ();
		}

		public string readGroupTitle (string groupName)
		{
			throw new NotImplementedException ();
		}

		public string[] readGroupKeys (string groupName)
		{
			throw new NotImplementedException ();
		}

		public string readHelp (string key)
		{
			throw new NotImplementedException ();
		}

		public string readPrompt (string key)
		{
			throw new NotImplementedException ();
		}

		public bool hasBounds (string key)
		{
			throw new NotImplementedException ();
		}

		public bool hasChoices (string key)
		{
			throw new NotImplementedException ();
		}

		public bool readDefaultBoolean (string key)
		{
			throw new NotImplementedException ();
		}

		public string readDefaultString (string key)
		{
			throw new NotImplementedException ();
		}

		public int readDefaultInt (string key)
		{
			throw new NotImplementedException ();
		}

		public long readDefaultLong (string key)
		{
			throw new NotImplementedException ();
		}

		public float readDefaultFloat (string key)
		{
			throw new NotImplementedException ();
		}

		public double readDefaultDouble (string key)
		{
			throw new NotImplementedException ();
		}

		public string[] readDefaultStringArray (string key)
		{
			throw new NotImplementedException ();
		}

		public bool[] readDefaultBooleanArray (string key)
		{
			throw new NotImplementedException ();
		}

		public int[] readDefaultIntArray (string key)
		{
			throw new NotImplementedException ();
		}

		public long[] readDefaultLongArray (string key)
		{
			throw new NotImplementedException ();
		}

		public float[] readDefaultFloatArray (string key)
		{
			throw new NotImplementedException ();
		}

		public double[] readDefaultDoubleArray (string key)
		{
			throw new NotImplementedException ();
		}

		public void readBoundsInt (string key, out int low, out int high)
		{
			throw new NotImplementedException ();
		}

		public void readBoundsLong (string key, out long low, out long high)
		{
			throw new NotImplementedException ();
		}

		public void readBoundsFloat (string key, out float low, out float high)
		{
			throw new NotImplementedException ();
		}

		public void readBoundsDouble (string key, out double low, out double high)
		{
			throw new NotImplementedException ();
		}

		public string[] readChoicesString (string key)
		{
			throw new NotImplementedException ();
		}

		public int[] readChoicesInt (string key)
		{
			throw new NotImplementedException ();
		}

		public long[] readChoicesLong (string key)
		{
			throw new NotImplementedException ();
		}

		public float[] readChoicesFloat (string key)
		{
			throw new NotImplementedException ();
		}

		public double[] readChoicesDouble (string key)
		{
			throw new NotImplementedException ();
		}
		#endregion

		#region BasicParameterPort implementation
		public gov.cca.TypeMap readConfigurationMap ()
		{
			throw new NotImplementedException ();
		}

		public void writeConfigurationMap (gov.cca.TypeMap map)
		{
			throw new NotImplementedException ();
		}

		public string[] readConfigurationKeys ()
		{
			throw new NotImplementedException ();
		}
		#endregion


	}
	
	
	
}

