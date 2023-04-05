 
package ${packageName};

public class Service${classNo} {

<#assign x=methodCount>
<#list 1..x as i>
    public String method${i?string('000')}() {
        return "";
    }
</#list>

}