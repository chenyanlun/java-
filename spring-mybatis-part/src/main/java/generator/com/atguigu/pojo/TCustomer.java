package generator.com.atguigu.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * @TableName t_customer
 */
@Data
public class TCustomer implements Serializable {
    private Integer customerId;

    private String customerName;

    private static final long serialVersionUID = 1L;
}