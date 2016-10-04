<?xml version="1.0"?><ComponentFunctorApplicationType xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" component_ref="br.ufc.mdcc.hpcshelf.mapreduce.connector.Splitter">
<argument parameter_id="platform_map_maintainer" xmlns="http://www.example.org/instantiator">
	<type component_ref="br.ufc.mdcc.hpcshelf.platform.maintainer.ComputeHost"></type>
</argument>
<argument parameter_id="platform_reduce_maintainer" xmlns="http://www.example.org/instantiator">
	<type component_ref="br.ufc.mdcc.hpcshelf.platform.maintainer.ComputeHost"></type>
</argument>
<argument parameter_id="platform_data_source_maintainer" xmlns="http://www.example.org/instantiator">
	<type component_ref="br.ufc.mdcc.hpcshelf.platform.maintainer.DataHost"></type>
</argument>
<argument parameter_id="platform_data_sink_maintainer" xmlns="http://www.example.org/instantiator">
	<type component_ref="br.ufc.mdcc.hpcshelf.platform.maintainer.DataHost"></type>
</argument>
<argument parameter_id="input_key_type" xmlns="http://www.example.org/instantiator">
	<type component_ref="br.ufc.mdcc.common.Integer" />
</argument>
<argument parameter_id="input_value_type" xmlns="http://www.example.org/instantiator">
	<type component_ref="br.ufc.mdcc.common.String" />
</argument>
<argument parameter_id="output_key_type" xmlns="http://www.example.org/instantiator">
	<type component_ref="br.ufc.mdcc.common.String" />
</argument>
<argument parameter_id="output_value_type" xmlns="http://www.example.org/instantiator">
	<type component_ref="br.ufc.mdcc.common.Integer" />
</argument>
<argument parameter_id="bin_function" xmlns="http://www.example.org/instantiator">
	<type component_ref="br.ufc.mdcc.hpcshelf.mapreduce.custom.PartitionFunction">
  		<argument parameter_id="input_key">
			<type component_ref="br.ufc.mdcc.common.Integer" /> 
		</argument>
	</type>
</argument>
<argument parameter_id="terminate_function" xmlns="http://www.example.org/instantiator">
  <type component_ref="br.ufc.mdcc.hpcshelf.mapreduce.custom.TerminateFunction">
  	<argument parameter_id="input_key_type"><type component_ref="br.ufc.mdcc.common.Integer" /> </argument>
  	<argument parameter_id="input_value_type"><type component_ref="br.ufc.mdcc.common.String" /> </argument>
  	<argument parameter_id="output_key_type"><type component_ref="br.ufc.mdcc.common.String" /> </argument>
  	<argument parameter_id="output_value_type"><type component_ref="br.ufc.mdcc.common.Integer" /> </argument>
  </type>
</argument>
</ComponentFunctorApplicationType>
