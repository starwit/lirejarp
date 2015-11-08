<form name="${domain?lower_case}Form">   
<div>
	<h1>{{title | translate}}</h1>
	<div class="content_wrapper content_mb_60">
		<div id="form">
			<div class="error">
				<b>{{message}}</b>
				<ul>
					<li ng-repeat="error in validationErrors">{{error.fieldname}}: {{error.message}}</li>
				</ul>
			</div>
			<div class="clear"></div>
			<#list (attributes) as attribute> 
			
			<#if attribute.pattern??><span class="error" ng-show="${domain?lower_case}Form.${attribute.columnName?lower_case}.$error.pattern">{{'error.pattern' | translate}}</span><div class="clear"></div></#if>	
			<#if !attribute.nullable><span class="error" ng-show="${domain?lower_case}Form.${attribute.columnName?lower_case}.$error.required">{{'error.required' | translate}}</span><div class="clear"></div></#if>	
			<#if attribute.min??><span class="error" ng-show="${domain?lower_case}Form.${attribute.columnName?lower_case}.$error.minlength">{{'error.minlength' | translate}}</span><div class="clear"></div></#if>
			<#if attribute.min??><span class="error" ng-show="${domain?lower_case}Form.${attribute.columnName?lower_case}.$error.maxlength">{{'error.maxlength' | translate}}</span><div class="clear"></div></#if>
			
			<#if attribute.dataType == "String"> 
			<label for="${attribute.columnName?lower_case}">{{'${domain?lower_case}.${attribute.columnName}' | translate}}:</label>
			<input name="${attribute.columnName?lower_case}" id="${attribute.columnName?lower_case}" type="text" ng-model="${domain?lower_case}.${attribute.columnName?uncap_first}" 
			<#if attribute.pattern??> ng-pattern="${attribute.pattern}"</#if>	
			<#if attribute.min??> ng-minlength="${attribute.min}"</#if>
			<#if attribute.max??> ng-maxlength="${attribute.max}"</#if>
			<#if !attribute.nullable> required</#if>
			/>
			<div class="clear"></div>
			</#if>
			<#if attribute.dataType == "Integer"> 
			<span class="error" ng-show="${domain?lower_case}Form.${attribute.columnName?lower_case}.$error.pattern">{{'error.number' | translate}}</span><div class="clear"></div>
			<label for="${attribute.columnName?lower_case}">{{'${domain?lower_case}.${attribute.columnName}' | translate}}:</label>
			<input name="${attribute.columnName?lower_case}" id="${attribute.columnName?lower_case}" type="text" ng-model="${domain?lower_case}.${attribute.columnName?uncap_first}" numberinput='' ng-pattern="/^[0-9]+$/"	
			<#if attribute.min??> ng-minlength="${attribute.min}"</#if>
			<#if attribute.max??> ng-maxlength="${attribute.max}"</#if>
			<#if !attribute.nullable> required</#if>
			/>
			<div class="clear"></div>
			</#if>
			<#if attribute.dataType == "BigDecimal"> 
			<span class="error" ng-show="${domain?lower_case}Form.${attribute.columnName?lower_case}.$error.pattern">{{'error.number' | translate}}</span><div class="clear"></div>
			<label for="${attribute.columnName?lower_case}">{{'${domain?lower_case}.${attribute.columnName}' | translate}}:</label>
			<input name="${attribute.columnName?lower_case}" id="${attribute.columnName?lower_case}" type="text" placeholder="_,_" ng-model="${domain?lower_case}.${attribute.columnName?uncap_first}" numberinput='' ng-pattern="/^\d{1,4}(\.\d{0,4})?$/"	
			<#if attribute.min??> ng-minlength="${attribute.min}"</#if>
			<#if attribute.max??> ng-maxlength="${attribute.max}"</#if>
			<#if !attribute.nullable> required</#if>			
			/>
			<div class="clear"></div>
			</#if>
			<#if attribute.dataType == "Double"> 
			<span class="error" ng-show="${domain?lower_case}Form.${attribute.columnName?lower_case}.$error.pattern">{{'error.number' | translate}}</span><div class="clear"></div>
			<label for="${attribute.columnName?lower_case}">{{'${domain?lower_case}.${attribute.columnName}' | translate}}:</label>
			<input name="${attribute.columnName?lower_case}" id="${attribute.columnName?lower_case}" type="text" placeholder="_,_" ng-model="${domain?lower_case}.${attribute.columnName?uncap_first}" numberinput='' ng-pattern="/^\d{1,4}(\.\d{0,4})?$/"
			<#if attribute.min??> ng-minlength="${attribute.min}"</#if>
			<#if attribute.max??> ng-maxlength="${attribute.max}"</#if>
			<#if !attribute.nullable> required</#if>				
			/>
			<div class="clear"></div>
			</#if>
			</#list>
			<button class="submit_btn left" ng-click="doMaintain()">Save</button>
			<button class="submit_btn left" ng-click="doBack()">Cancel</button>
		</div>
	</div>
</div>
</form>