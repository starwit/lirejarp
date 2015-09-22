<div id="templatemo_sidebar">
	<div class="sidebar_content_box">
	</div>
</div>

<div id="templatemo_content">
	<h1>{{title}}</h1>
	<div class="content_wrapper content_mb_60">
		<table>
			<thead>
				<#list attributes> 
				<tr>
					<#items as attribute>
					<th>${attribute.columnName}</th>
					</#items>
				</tr>	
				</#list>
			</thead>
			<tbody>
				<#list attributes> 
				<tr>
					<#items as attribute>
					<td>remove me!</td>
					</#items>
				</tr>	
				</#list>
			</tbody>
			<tfoot></tfoot>
		</table>
	</div>
</div>