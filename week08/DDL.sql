create schema demo_ds_0;
create schema demo_ds_1;


CREATE TABLE demo_ds_0.order_0 (
  id BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  order_code VARCHAR(100) NOT NULL COMMENT '订单号',
  goods_code VARCHAR(100) NOT NULL COMMENT '货号',
  sale_amount DECIMAL(12,2) NOT NULL COMMENT '售价',
  num INT(11) NOT NULL COMMENT '数量',
  total_amount DECIMAL(12,2) NOT NULL COMMENT '总价',
  customer_id BIGINT(20) NOT NULL COMMENT '客户ID',
  status TINYINT(1) NOT NULL DEFAULT 1 COMMENT '状态，1可用，0删除',
  creator VARCHAR(100) NOT NULL DEFAULT '' COMMENT '创建人',
  create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  modifier VARCHAR(100) NOT NULL DEFAULT '' COMMENT '修改人',
  modify_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_order_code` (`order_code`),
  KEY `idx_goods_code` (`goods_code`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='订单表';