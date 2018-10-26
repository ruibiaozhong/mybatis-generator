package com.leihou.so.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 订单号码
     */
    @Column(name = "order_num")
    private String orderNum;

    @Column(name = "check_in_num")
    private String checkInNum;

    /**
     * 订单状态  5待支付 10未使用 20已使用 30已取消
     */
    private Integer status;

    private Date created;

    private Date updated;

    /**
     * 备注
     */
    private String remark;

    @Column(name = "user_id")
    private Integer userId;

    /**
     * 订单类型
     */
    private Integer type;

    /**
     * 归属空间的id
     */
    @Column(name = "space_id")
    private Integer spaceId;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取订单号码
     *
     * @return order_num - 订单号码
     */
    public String getOrderNum() {
        return orderNum;
    }

    /**
     * 设置订单号码
     *
     * @param orderNum 订单号码
     */
    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * @return check_in_num
     */
    public String getCheckInNum() {
        return checkInNum;
    }

    /**
     * @param checkInNum
     */
    public void setCheckInNum(String checkInNum) {
        this.checkInNum = checkInNum;
    }

    /**
     * 获取订单状态  5待支付 10未使用 20已使用 30已取消
     *
     * @return status - 订单状态  5待支付 10未使用 20已使用 30已取消
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置订单状态  5待支付 10未使用 20已使用 30已取消
     *
     * @param status 订单状态  5待支付 10未使用 20已使用 30已取消
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return created
     */
    public Date getCreated() {
        return created;
    }

    /**
     * @param created
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * @return updated
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * @param updated
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取订单类型
     *
     * @return type - 订单类型
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置订单类型
     *
     * @param type 订单类型
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取归属空间的id
     *
     * @return space_id - 归属空间的id
     */
    public Integer getSpaceId() {
        return spaceId;
    }

    /**
     * 设置归属空间的id
     *
     * @param spaceId 归属空间的id
     */
    public void setSpaceId(Integer spaceId) {
        this.spaceId = spaceId;
    }
}