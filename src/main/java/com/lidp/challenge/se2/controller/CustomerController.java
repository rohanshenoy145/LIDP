package  com.lidp.challenge.se2.controller;

import com.lidp.challenge.se2.service.CustomerService;
import com.lidp.challenge.se2.service.AddressService;
import com.lidp.challenge.se2.service.SalesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lidp.challenge.se2.domain.CustomerAPI;
import com.lidp.challenge.se2.domain.AddressAPI;
import com.lidp.challenge.se2.domain.SalesAPI;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("")
public class CustomerController {
  private final CustomerService customerService;
  private final AddressService addressService;
  private final SalesService   salesService;

  @Autowired
  public CustomerController(CustomerService customerService,AddressService addressService,SalesService salesService) {
    this.customerService = customerService;
    this.addressService = addressService;
    this.salesService = salesService;
  }

  @PostMapping("/customers")
  public void save(@RequestBody CustomerAPI customerAPI) {
    this.customerService.save(customerAPI);
  }

  @GetMapping("/customers")
  public List<CustomerAPI> findAll() {
    return this.customerService.findAll();
  }

  @GetMapping("/customers/{id}")
  public CustomerAPI findById(@PathVariable Integer id) {
    return this.customerService.findById(id);
  }

  @DeleteMapping("/customers/{id}")
  public void deleteById(@PathVariable Integer id) {
    this.customerService.deleteById(id);
  }

  @PostMapping ("/customers/{id}/addresses")
  public void addAddress(@PathVariable Integer id,@RequestBody AddressAPI addressAPI){
    this.addressService.addAddress(id,addressAPI);

  }

  @GetMapping ("/addresses")
  public List <AddressAPI> findAllAddresses(){
    return this.addressService.findAllAddresses();
  }

  @GetMapping("/customers/{id}/addresses")
  public List <AddressAPI> findAddressesById(@PathVariable Integer id){
    return this.addressService.findAddresses(id);
  }

  @DeleteMapping("/addresses/{id}")
  public void deleteAddress(@PathVariable Integer id){
    this.addressService.deleteAddress(id);
  }


  @PostMapping ("/customers/{id}/sales")
  public void addSale(@PathVariable Integer id,@RequestBody SalesAPI salesAPI){
    this.salesService.addSale(id,salesAPI);

  }

  @GetMapping ("/customers/{id}/sales")
  public List <SalesAPI> findSales(@PathVariable Integer id){
    return this.salesService.findSales(id);
  }

  @GetMapping ("/customers/{id}/sales/total")
  public BigDecimal findTotalSales(@PathVariable Integer id){
    return this.salesService.getTotalSalesByCustomer(id);
  }
  
  @GetMapping ("/sales/date/total")
  public BigDecimal findTotalSalesDate(@RequestParam("start") String startDateStr, @RequestParam("end") String endDateStr){
    LocalDate startDate = LocalDate.parse(startDateStr);
    LocalDate endDate = LocalDate.parse(endDateStr);
    return this.salesService.getTotalSalesByDate(startDate,endDate);
  
  }

  @GetMapping ("/sales/date")
  public List <SalesAPI> findSalesDate(@RequestParam("start") String startDateStr, @RequestParam("end") String endDateStr){
    LocalDate startDate = LocalDate.parse(startDateStr);  // Parsing the dates from query params
    LocalDate endDate = LocalDate.parse(endDateStr);
    return this.salesService.getSalesByDate(startDate,endDate);
  }









}
