<?xml version="1.0"?><ComponentFunctorApplicationType xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" component_ref="br.ufc.mdcc.hpcshelf.mapreduce.computation.Mapper">
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
<argument parameter_id="map_function" xmlns="http://www.example.org/instantiator">
	<type component_ref="br.ufc.mdcc.hpcshelf.mapreduce.example.cw.WordCounter"></type>
</argument>
<argument parameter_id="platform_maintainer" xmlns="http://www.example.org/instantiator">
	<type component_ref="br.ufc.mdcc.hpcshelf.platform.maintainer.ComputeHost"></type>
</argument>
</ComponentFunctorApplicationType>
