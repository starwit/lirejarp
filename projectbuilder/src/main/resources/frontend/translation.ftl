{
<#list (attributes) as attribute> 
	"${domain?uncap_first}.${attribute.columnName}": "${attribute.columnName}",
</#list>
	"${domain?uncap_first}.all.title": "${domain} anzeigen",
	"${domain?uncap_first}.create.title": "${domain} erfassen",
	"${domain?uncap_first}.update.title": "${domain} bearbeiten"
}