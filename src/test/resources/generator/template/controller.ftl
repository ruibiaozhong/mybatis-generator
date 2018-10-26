package ${basePackage}.controller;
import ${basePackage}.entity.${modelNameUpperCamel};
import ${basePackage}.service.${modelNameUpperCamel}Service;
import com.leihou.so.util.DateUtils;
import com.leihou.so.constant.common.DatePattern;
import com.leihou.so.bo.Result;
import com.leihou.so.bo.InfoResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leihou.so.base.BaseController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Date;
import javax.annotation.Resource;


/**
* @description: 操作${tableName}表
* @author: ${author}
* @date ${date}
* @version
*/
@RestController("${modelNameLowerCamel}Controller")
@RequestMapping("/${baseRequestMapping}s")
public class ${modelNameUpperCamel}Controller extends BaseController {

    @Resource
    private ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;


    @ApiOperation(value = "创建'${tableName}'表中一条信息", notes = "通过post方法请求，传入表中字段的对应信息，创建一条数据。并返回给View层")
    @PostMapping("/insert")
    public Result create(
                    HttpServletRequest request,
                    @RequestHeader(value = "token") String token,
                <#list attribute?keys as key>
                <#if key_has_next>
                    <#if "Date" == attribute["${key}"]>
                @RequestParam(value = "${key}", required = false) String ${key},
                    <#else >
                @RequestParam(value = "${key}", required = false) ${attribute["${key}"]} ${key},
                    </#if>
                <#else >
                    <#if "Date" == attribute["${key}"]>
                @RequestParam(value = "${key}", required = false) String ${key}
                    <#else >
                @RequestParam(value = "${key}", required = false) ${attribute["${key}"]} ${key}
                    </#if>
                </#if>
                </#list>) {
        InfoResult<${modelNameUpperCamel}> result = new InfoResult<>();
        ${modelNameUpperCamel} ${modelNameLowerCamel} = new ${modelNameUpperCamel}();
        <#list attribute?keys as key>
            <#if "Date" == attribute["${key}"]>
            if (null != ${key}) {
                ${modelNameLowerCamel}.set${key?cap_first}(DateUtils.parse(${key}, DatePattern.LONG_DASH));
            }
            </#if>
            <#if "Date" != attribute["${key}"]>
            if (null != ${key}) {
                ${modelNameLowerCamel}.set${key?cap_first}(${key});
            }
            </#if>
        </#list>
        result.setInfo(${modelNameLowerCamel}Service.selectByPrimaryKey(${modelNameLowerCamel}Service.insert(${modelNameLowerCamel})));
        return result;
    }


    @ApiOperation(value = "删除'${tableName}'表中的某条记录", notes = "根据url传入的数据id，删除整条记录。")
    @DeleteMapping("/delete/{${id}}")
    public Result delete(@RequestHeader(value = "token") String token, @PathVariable(value = "${id}") ${attribute["${id}"]} ${id}) {
	    ${modelNameLowerCamel}Service.deleteByPrimaryKey(${id});
        Result result = new Result();
	    return result;
    }

    @ApiOperation(value = "修改'${tableName}'表中的某条记录", notes = "根据url传入的数据id，确定修改表中的某条记录，传入表中字段要修改的信息，不传代表不修改。并返回给View层")
    @PutMapping("update")
    public Result update(HttpServletRequest request,
                         HttpServletResponse response,
                         @RequestHeader(value = "token") String token,
                        <#list attribute?keys as key>
                        <#if key_has_next>
                                <#if "Date" == attribute["${key}"]>
                        @RequestParam(value = "${key}", required = false) String ${key},
                                <#else >
                        @RequestParam(value = "${key}", required = false) ${attribute["${key}"]} ${key},
                                </#if>
                            <#else >
                                <#if "Date" == attribute["${key}"]>
                        @RequestParam(value = "${key}", required = false) String ${key}
                                <#else >
                        @RequestParam(value = "${key}", required = false) ${attribute["${key}"]} ${key}
                                </#if>
                        </#if>
                        </#list>) {
        InfoResult<${modelNameUpperCamel}> result = new InfoResult<>();
        ${modelNameUpperCamel} ${modelNameLowerCamel} = ${modelNameLowerCamel}Service.selectByPrimaryKey(${id});

        if (null == ${modelNameLowerCamel}) {
            response.setStatus(404);
            result.setInvalidMsg("the asset to be edited doesn't exist");
            return result;
        }
    <#list attribute?keys as key>
        <#if "Date" == attribute["${key}"]>
        if (null != ${key}) {
            ${modelNameLowerCamel}.set${key?cap_first}(DateUtils.parse(${key}, DatePattern.LONG_DASH));
        }
        </#if>
        <#if "Date" != attribute["${key}"]>
        if (null != ${key}) {
            ${modelNameLowerCamel}.set${key?cap_first}(${key});
        }
        </#if>
    </#list>

	    ${modelNameLowerCamel}Service.updateByPrimaryKey(${modelNameLowerCamel});
        result.setInfo(${modelNameLowerCamel}Service.selectByPrimaryKey(${id}));
	    return result;
    }

    @GetMapping("/detail/{${id}}")
    public Result detail(HttpServletResponse response, @RequestHeader(value = "token") String token, @PathVariable(value = "${id}") ${attribute["${id}"]} ${id}) {
        InfoResult<${modelNameUpperCamel}> result = new InfoResult<>();
        ${modelNameUpperCamel} ${modelNameLowerCamel} = ${modelNameLowerCamel}Service.selectByPrimaryKey(${id});
        if (null == ${modelNameLowerCamel}) {
            response.setStatus(404);
            result.setInvalidMsg("the asset to be edited doesn't exist");
            return result;
        }
        result.setInfo(${modelNameLowerCamel});
        return result;
    }




    @ApiOperation(value = "查询'${tableName}'表中的多条记录或者新增某条记录", notes = "get传参：根据url传入的filters（过滤条件），查询对应的多条数据。数据数量取决于pageNo和pageSize；数据的先后顺序取决于sortItem，sortOrder")
    @GetMapping("/")
    public Result list(HttpServletRequest request,
                        @RequestHeader(value = "token", required = false) String token,
                        @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                        @RequestParam(value = "pageSize", required = false) Integer pageSize,
                        @RequestParam(value = "sortItem", required = false) String sortItem,
                        @RequestParam(value = "sortOrder", required = false) String sortOrder,
                        @RequestParam(value = "filters", required = false) String filters,
                        @RequestParam(value = "includes", required = false) String includes,
                        @RequestParam(value = "refers", required = false) String refers,
                        @RequestParam(value = "relates", required = false) String relates) {
        InfoResult result = new InfoResult();
        List list = ${modelNameLowerCamel}Service.listWithPagingAndFilter(pageNumber, pageSize, sortItem, sortItem, filters, includes, refers, relates);
        result.setInfo(list);
        return result;
    }
}
