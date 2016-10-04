<?xml version="1.0"?><ComponentFunctorApplicationType xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" component_ref="br.ufc.mdcc.hpcshelf.mapreduce.connector.Shuffler">
<argument parameter_id="platform_map_maintainer" xmlns="http://www.example.org/instantiator">
	<type component_ref="br.ufc.mdcc.hpcshelf.platform.maintainer.ComputeHost"></type>
</argument>
<argument parameter_id="platform_reduce_maintainer" xmlns="http://www.example.org/instantiator">
<type component_ref="br.ufc.mdcc.hpcshelf.platform.maintainer.ComputeHost"></type>
</argument>
<argument parameter_id="intermediate_key_type" xmlns="http://www.example.org/instantiator">
	<type component_ref="br.ufc.mdcc.common.String" />
</argument>
<argument parameter_id="intermediate_value_type" xmlns="http://www.example.org/instantiator">
	<type component_ref="br.ufc.mdcc.common.Integer" />
</argument>
<argument parameter_id="partition_function" xmlns="http://www.example.org/instantiator">
	<type component_ref="br.ufc.mdcc.hpcshelf.mapreduce.custom.PartitionFunction">
		<argument parameter_id="input_key">
			<type component_ref="br.ufc.mdcc.common.String" />
 		</argument>
	</type>
</argument>
</ComponentFunctorApplicationType>
