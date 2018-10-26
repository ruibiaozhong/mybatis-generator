package com.leihou.so.controller;
import com.leihou.so.entity.User;
import com.leihou.so.service.UserService;
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
* @description: 操作t_user表
* @author: ruibiaozhong
* @date 2018/10/26
* @version
*/
@RestController("userController")
@RequestMapping("/users")
public class UserController extends BaseController {

    @Resource
    private UserService userService;


    @ApiOperation(value = "创建't_user'表中一条信息", notes = "通过post方法请求，传入表中字段的对应信息，创建一条数据。并返回给View层")
    @PostMapping("/insert")
    public Result create(
                    HttpServletRequest request,
                    @RequestHeader(value = "token") String token,
                @RequestParam(value = "id", required = false) Integer id,
                                @RequestParam(value = "telephone", required = false) String telephone,
                                @RequestParam(value = "created", required = false) String created,
                                @RequestParam(value = "updated", required = false) String updated,
                                @RequestParam(value = "channel", required = false) String channel,
                                @RequestParam(value = "companyId", required = false) Integer companyId,
                                @RequestParam(value = "status", required = false) Integer status,
                                @RequestParam(value = "name", required = false) String name,
                                @RequestParam(value = "role", required = false) Integer role,
                                @RequestParam(value = "headImgUrl", required = false) String headImgUrl,
                                @RequestParam(value = "sex", required = false) Integer sex,
                                @RequestParam(value = "position", required = false) String position,
                                @RequestParam(value = "remark", required = false) String remark,
                                @RequestParam(value = "remarkName", required = false) String remarkName
                ) {
        InfoResult<User> result = new InfoResult<>();
        User user = new User();
            if (null != id) {
                user.setId(id);
            }
            if (null != telephone) {
                user.setTelephone(telephone);
            }
            if (null != created) {
                user.setCreated(DateUtils.parse(created, DatePattern.LONG_DASH));
            }
            if (null != updated) {
                user.setUpdated(DateUtils.parse(updated, DatePattern.LONG_DASH));
            }
            if (null != channel) {
                user.setChannel(channel);
            }
            if (null != companyId) {
                user.setCompanyId(companyId);
            }
            if (null != status) {
                user.setStatus(status);
            }
            if (null != name) {
                user.setName(name);
            }
            if (null != role) {
                user.setRole(role);
            }
            if (null != headImgUrl) {
                user.setHeadImgUrl(headImgUrl);
            }
            if (null != sex) {
                user.setSex(sex);
            }
            if (null != position) {
                user.setPosition(position);
            }
            if (null != remark) {
                user.setRemark(remark);
            }
            if (null != remarkName) {
                user.setRemarkName(remarkName);
            }
        result.setInfo(userService.selectByPrimaryKey(userService.insert(user)));
        return result;
    }


    @ApiOperation(value = "删除't_user'表中的某条记录", notes = "根据url传入的数据id，删除整条记录。")
    @DeleteMapping("/delete/{id}")
    public Result delete(@RequestHeader(value = "token") String token, @PathVariable(value = "id") Integer id) {
	    userService.deleteByPrimaryKey(id);
        Result result = new Result();
	    return result;
    }

    @ApiOperation(value = "修改't_user'表中的某条记录", notes = "根据url传入的数据id，确定修改表中的某条记录，传入表中字段要修改的信息，不传代表不修改。并返回给View层")
    @PutMapping("update")
    public Result update(HttpServletRequest request,
                         HttpServletResponse response,
                         @RequestHeader(value = "token") String token,
                        @RequestParam(value = "id", required = false) Integer id,
                                                @RequestParam(value = "telephone", required = false) String telephone,
                                                @RequestParam(value = "created", required = false) String created,
                                                @RequestParam(value = "updated", required = false) String updated,
                                                @RequestParam(value = "channel", required = false) String channel,
                                                @RequestParam(value = "companyId", required = false) Integer companyId,
                                                @RequestParam(value = "status", required = false) Integer status,
                                                @RequestParam(value = "name", required = false) String name,
                                                @RequestParam(value = "role", required = false) Integer role,
                                                @RequestParam(value = "headImgUrl", required = false) String headImgUrl,
                                                @RequestParam(value = "sex", required = false) Integer sex,
                                                @RequestParam(value = "position", required = false) String position,
                                                @RequestParam(value = "remark", required = false) String remark,
                                                @RequestParam(value = "remarkName", required = false) String remarkName
                        ) {
        InfoResult<User> result = new InfoResult<>();
        User user = userService.selectByPrimaryKey(id);

        if (null == user) {
            response.setStatus(404);
            result.setInvalidMsg("the asset to be edited doesn't exist");
            return result;
        }
        if (null != id) {
            user.setId(id);
        }
        if (null != telephone) {
            user.setTelephone(telephone);
        }
        if (null != created) {
            user.setCreated(DateUtils.parse(created, DatePattern.LONG_DASH));
        }
        if (null != updated) {
            user.setUpdated(DateUtils.parse(updated, DatePattern.LONG_DASH));
        }
        if (null != channel) {
            user.setChannel(channel);
        }
        if (null != companyId) {
            user.setCompanyId(companyId);
        }
        if (null != status) {
            user.setStatus(status);
        }
        if (null != name) {
            user.setName(name);
        }
        if (null != role) {
            user.setRole(role);
        }
        if (null != headImgUrl) {
            user.setHeadImgUrl(headImgUrl);
        }
        if (null != sex) {
            user.setSex(sex);
        }
        if (null != position) {
            user.setPosition(position);
        }
        if (null != remark) {
            user.setRemark(remark);
        }
        if (null != remarkName) {
            user.setRemarkName(remarkName);
        }

	    userService.updateByPrimaryKey(user);
        result.setInfo(userService.selectByPrimaryKey(id));
	    return result;
    }

    @GetMapping("/detail/{id}")
    public Result detail(HttpServletResponse response, @RequestHeader(value = "token") String token, @PathVariable(value = "id") Integer id) {
        InfoResult<User> result = new InfoResult<>();
        User user = userService.selectByPrimaryKey(id);
        if (null == user) {
            response.setStatus(404);
            result.setInvalidMsg("the asset to be edited doesn't exist");
            return result;
        }
        result.setInfo(user);
        return result;
    }




    @ApiOperation(value = "查询't_user'表中的多条记录或者新增某条记录", notes = "get传参：根据url传入的filters（过滤条件），查询对应的多条数据。数据数量取决于pageNo和pageSize；数据的先后顺序取决于sortItem，sortOrder")
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
        List list = userService.listWithPagingAndFilter(pageNumber, pageSize, sortItem, sortItem, filters, includes, refers, relates);
        result.setInfo(list);
        return result;
    }
}
