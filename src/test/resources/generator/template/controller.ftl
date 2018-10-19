package ${basePackage}.controller;
import ${basePackage}.entity.${modelNameUpperCamel};
import ${basePackage}.service.${modelNameUpperCamel}Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
<#-- import io.swagger.annotations.ApiOperation; -->

import java.util.List;
import javax.annotation.Resource;

/**
 *
 * Created by ${author} on ${date}.
 */
@RestController
@RequestMapping("/${baseRequestMapping}/")
public class ${modelNameUpperCamel}Controller {

    @Resource
    ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;


<#--    @ApiOperation(value = "创建'${modelNameUpperCamel}'表中一条信息", notes = "通过post方法请求，传入表中字段的对应信息，创建一条数据。并返回给View层") -->
    @PostMapping("create")
    public String add(${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}Service.insert(${modelNameLowerCamel});
        return "";
    }

    @DeleteMapping("delete")
    public String delete(@RequestParam Integer id) {
	    ${modelNameLowerCamel}Service.deleteByPrimaryKey(id);
	    return "";
    }

    @PutMapping("update")
    public String update(${modelNameUpperCamel} ${modelNameLowerCamel}) {
	    ${modelNameLowerCamel}Service.updateByPrimaryKey(${modelNameLowerCamel});
	    return "";
    }

    @GetMapping("detail")
    public String detail(@RequestParam Integer id) {
        ${modelNameUpperCamel} ${modelNameLowerCamel} = ${modelNameLowerCamel}Service.selectByPrimaryKey(id);



        return ${modelNameLowerCamel}.toString();
    }

    @GetMapping("list")
    public String list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<${modelNameUpperCamel}> list = ${modelNameLowerCamel}Service.selectAll();
        PageInfo pageInfo = new PageInfo(list);
        return list.toString();
    }
}
