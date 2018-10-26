package com.leihou.so.controller;
import com.leihou.so.entity.Order;
import com.leihou.so.service.OrderService;
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
* @description: 操作t_order表
* @author: ruibiaozhong
* @date 2018/10/26
* @version
*/
@RestController("orderController")
@RequestMapping("/orders/")
public class OrderController extends BaseController {

    @Resource
    private OrderService orderService;


    @ApiOperation(value = "创建't_order'表中一条信息", notes = "通过post方法请求，传入表中字段的对应信息，创建一条数据。并返回给View层")
    @PostMapping("/insert")
    public Result create(
                    HttpServletRequest request,
                    @RequestHeader(value = "token") String token,
                @RequestParam(value = "id", required = false) Integer id,
                                @RequestParam(value = "orderNum", required = false) String orderNum,
                                @RequestParam(value = "checkInNum", required = false) String checkInNum,
                                @RequestParam(value = "status", required = false) Integer status,
                                @RequestParam(value = "created", required = false) String created,
                                @RequestParam(value = "updated", required = false) String updated,
                                @RequestParam(value = "remark", required = false) String remark,
                                @RequestParam(value = "userId", required = false) Integer userId,
                                @RequestParam(value = "type", required = false) Integer type,
                                @RequestParam(value = "spaceId", required = false) Integer spaceId
                ) {
        InfoResult<Order> result = new InfoResult<>();
        Order order = new Order();
            if (null != id) {
                order.setId(id);
            }
            if (null != orderNum) {
                order.setOrderNum(orderNum);
            }
            if (null != checkInNum) {
                order.setCheckInNum(checkInNum);
            }
            if (null != status) {
                order.setStatus(status);
            }
            if (null != created) {
                order.setCreated(DateUtils.parse(created, DatePattern.LONG_DASH));
            }
            if (null != updated) {
                order.setUpdated(DateUtils.parse(updated, DatePattern.LONG_DASH));
            }
            if (null != remark) {
                order.setRemark(remark);
            }
            if (null != userId) {
                order.setUserId(userId);
            }
            if (null != type) {
                order.setType(type);
            }
            if (null != spaceId) {
                order.setSpaceId(spaceId);
            }
        result.setInfo(orderService.selectByPrimaryKey(orderService.insert(order)));
        return result;
    }


    @ApiOperation(value = "删除't_order'表中的某条记录", notes = "根据url传入的数据id，删除整条记录。")
    @DeleteMapping("/delete/{id}")
    public Result delete(@RequestHeader(value = "token") String token, @PathVariable(value = "id") Integer id) {
	    orderService.deleteByPrimaryKey(id);
        Result result = new Result();
	    return result;
    }

    @ApiOperation(value = "修改't_order'表中的某条记录", notes = "根据url传入的数据id，确定修改表中的某条记录，传入表中字段要修改的信息，不传代表不修改。并返回给View层")
    @PutMapping("update")
    public Result update(HttpServletRequest request,
                         HttpServletResponse response,
                         @RequestHeader(value = "token") String token,
                        @RequestParam(value = "id", required = false) Integer id,
                                                @RequestParam(value = "orderNum", required = false) String orderNum,
                                                @RequestParam(value = "checkInNum", required = false) String checkInNum,
                                                @RequestParam(value = "status", required = false) Integer status,
                                                @RequestParam(value = "created", required = false) String created,
                                                @RequestParam(value = "updated", required = false) String updated,
                                                @RequestParam(value = "remark", required = false) String remark,
                                                @RequestParam(value = "userId", required = false) Integer userId,
                                                @RequestParam(value = "type", required = false) Integer type,
                                                @RequestParam(value = "spaceId", required = false) Integer spaceId
                        ) {
        InfoResult<Order> result = new InfoResult<>();
        Order order = orderService.selectByPrimaryKey(id);

        if (null == order) {
            response.setStatus(404);
            result.setInvalidMsg("the asset to be edited doesn't exist");
            return result;
        }
        if (null != id) {
            order.setId(id);
        }
        if (null != orderNum) {
            order.setOrderNum(orderNum);
        }
        if (null != checkInNum) {
            order.setCheckInNum(checkInNum);
        }
        if (null != status) {
            order.setStatus(status);
        }
        if (null != created) {
            order.setCreated(DateUtils.parse(created, DatePattern.LONG_DASH));
        }
        if (null != updated) {
            order.setUpdated(DateUtils.parse(updated, DatePattern.LONG_DASH));
        }
        if (null != remark) {
            order.setRemark(remark);
        }
        if (null != userId) {
            order.setUserId(userId);
        }
        if (null != type) {
            order.setType(type);
        }
        if (null != spaceId) {
            order.setSpaceId(spaceId);
        }

	    orderService.updateByPrimaryKey(order);
        result.setInfo(orderService.selectByPrimaryKey(id));
	    return result;
    }

    @GetMapping("/detail/{id}")
    public Result detail(HttpServletResponse response, @RequestHeader(value = "token") String token, @PathVariable(value = "id") Integer id) {
        InfoResult<Order> result = new InfoResult<>();
        Order order = orderService.selectByPrimaryKey(id);
        if (null == order) {
            response.setStatus(404);
            result.setInvalidMsg("the asset to be edited doesn't exist");
            return result;
        }
        result.setInfo(order);
        return result;
    }




    @ApiOperation(value = "查询't_order'表中的多条记录或者新增某条记录", notes = "get传参：根据url传入的filters（过滤条件），查询对应的多条数据。数据数量取决于pageNo和pageSize；数据的先后顺序取决于sortItem，sortOrder")
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
        List list = orderService.listWithPagingAndFilter(pageNumber, pageSize, sortItem, sortItem, filters, includes, refers, relates);
        result.setInfo(list);
        return result;
    }
}
