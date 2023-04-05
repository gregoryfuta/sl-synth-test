package ${packageName};

import ${packageName?replace("api", "service")}.Service${classNo};

public class Controller${classNo} {

    private Service${classNo} service;

    public Controller${classNo}(Service${classNo} service) {
        this.service = service;
    }

<#assign x=methodCount>
<#list 1..x as i>
    public String ctrlMethod${i?string('000')}() {
        return service.method${i?string('000')}();
    }
</#list>

}