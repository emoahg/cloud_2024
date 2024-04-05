package pers.emo.payment.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import pers.emo.payment.dto.PayDTO;
import pers.emo.payment.entities.Pay;
import pers.emo.payment.service.PayService;

import java.util.List;

@RestController
@RequestMapping("/pay")
@RequiredArgsConstructor
@Tag(name = "支付微服务模块", description = "支付CRUD")
public class PayController {

    private final PayService payService;

    @PostMapping("/add")
    @Operation(summary = "新增", description = "新增支付流水方法,json串做参数")
    public String addPay(@RequestBody Pay pay){
        System.out.println(pay.toString());
        int i = payService.add(pay);
        return "成功插入记录，返回值："+i;
    }

    @DeleteMapping(value = "/del/{id}")
    @Operation(summary = "删除", description = "删除支付流水方法")
    public Integer deletePay(@PathVariable("id") Integer id) {
        return payService.delete(id);
    }
    @PutMapping(value = "/update")
    @Operation(summary = "修改", description = "修改支付流水方法")
    public String updatePay(@RequestBody PayDTO payDTO){
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO, pay);

        int i = payService.update(pay);
        return "成功修改记录，返回值："+i;
    }

    @GetMapping(value = "/get/{id}")
    @Operation(summary = "按照ID查流水",description = "查询支付流水方法")
    public Pay getById(@PathVariable("id") Integer id){
        return payService.getById(id);
    }

    @GetMapping(value = "/all")
    @Operation(summary = "查询所有流水",description = "查询支付流水方法")
    public List<Pay> getAll(){
        return payService.getAll();
    }
}
