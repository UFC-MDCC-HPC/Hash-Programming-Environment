<?xml version="1.0"?><ComponentFunctorApplicationType xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" component_ref="br.ufc.mdcc.hpcshelf.mapreduce.connector.Splitter">
<argument parameter_id="input_key_type" xmlns="http://www.example.org/instantiator">
	<type component_ref="br.ufc.mdcc.common.Integer" />
</argument>
<argument parameter_id="input_value_type" xmlns="http://www.example.org/instantiator">
	<type component_ref="br.ufc.mdcc.common.String" />
</argument>
<argument parameter_id="bin_function" xmlns="http://www.example.org/instantiator">
	<type component_ref="br.ufc.mdcc.hpcshelf.mapreduce.custom.PartitionFunction">
  		<argument parameter_id="input_key">
			<type component_ref="br.ufc.mdcc.common.Integer" /> 
		</argument>
	</type>
</argument>
</ComponentFunctorApplicationType>
