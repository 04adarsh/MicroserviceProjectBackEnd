//package com.aviasoletechnologies.productservice.controller;
//
//import com.aviasoletechnologies.productservice.dto.PaymentResponse;
//import com.aviasoletechnologies.productservice.dto.UpdatePayment;
//import com.aviasoletechnologies.productservice.exception.CustomException;
//import com.aviasoletechnologies.productservice.model.MyOrders;
//import com.aviasoletechnologies.productservice.model.OrderDto;
//import com.aviasoletechnologies.productservice.repository.OrderRepository;
//import com.razorpay.RazorpayException;
//import org.json.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import com.razorpay.RazorpayClient;
//
//@RestController
//@CrossOrigin(origins = {"http://localhost:4200","*"},
//        allowedHeaders = {"Origin", "Access-Control-Allow-Origin", "X-Requested-With", "Content-Type", "Accept", "Authorization"})
//public class PaymentController {
//
//    @Autowired
//    private OrderRepository orderRepository;
//
//    @PostMapping("/user/create-order")
//    public ResponseEntity<?> createOrder(@RequestBody OrderDto order) throws RazorpayException {
//    int amount=order.getAmount();
//    var client=new RazorpayClient("rzp_test_tF42jI563EUWQE","eGakMHimSEH7Lzb1f002golU");
//        JSONObject ob=new JSONObject();
//        ob.put("amount",amount*100);
//        ob.put("currency","INR");
//        ob.put("receipt","txn_12345");
//        //creating new order
//       com.razorpay.Order orderResp= client.Orders.create(ob);
//        System.out.println(orderResp);
//        MyOrders orderObj=new MyOrders();
//        int amount1=orderResp.get("amount");
//        amount1=amount1/100;
//        orderObj.setAmount(amount1);
//        orderObj.setOrderId(orderResp.get("id"));
//        orderObj.setStatus(orderResp.get("status"));
//        orderObj.setReceipt(orderResp.get("receipt"));
//        orderObj.setPaymentId(null);
//        this.orderRepository.save(orderObj);
//    return ResponseEntity.ok(orderResp.toString());
//    }
//
//    @PutMapping("/user/update-order")
//    public ResponseEntity<?> updateOrder(@RequestBody UpdatePayment updatePayment){
//        MyOrders order=this.orderRepository.findMyOrderByOrderId(updatePayment.getOrderId());
//        if(order==null){
//            throw new CustomException("order details not found");
//        }
//        order.setPaymentId(updatePayment.getPaymentId());
//        order.setStatus(updatePayment.getStatus());
//        this.orderRepository.save(order);
//        return ResponseEntity.ok(new PaymentResponse("payment successfull"));
//    }
//}
