package pers.emo.payment.controller;

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
public class PayController {

    private final PayService payService;

    @PostMapping("/add")
    public String addPay(@RequestBody Pay pay){
        System.out.println(pay.toString());
        int i = payService.add(pay);
        return "成功插入记录，返回值："+i;
    }

    @DeleteMapping(value = "/del/{id}")
    public Integer deletePay(@PathVariable("id") Integer id) {
        return payService.delete(id);
    }
    @PutMapping(value = "/update")
    public String updatePay(@RequestBody PayDTO payDTO){
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO, pay);

        int i = payService.update(pay);
        return "成功修改记录，返回值："+i;
    }
    @GetMapping(value = "/get/{id}")
    public Pay getById(@PathVariable("id") Integer id){
        return payService.getById(id);
    }

    @GetMapping(value = "/all")
    public List<Pay> getAll(){
        return payService.getAll();
    }
}
