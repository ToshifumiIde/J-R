package net.javaguides.springboot.controller;

import lombok.RequiredArgsConstructor;
import net.javaguides.springboot.dto.EmployeeReadDto;
import net.javaguides.springboot.dto.EmployeeRegistrationDto;
import net.javaguides.springboot.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {

  private final EmployeeService employeeService;


  /**
   * 従業員を登録する REST API
   *
   * @param employeeRegistrationDto 従業員登録用DTO
   * @return void
   */
  @PostMapping
  public ResponseEntity<Void> create(@RequestBody EmployeeRegistrationDto employeeRegistrationDto) {
    employeeService.createEmployee(employeeRegistrationDto);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  /**
   * UUIDを指定してEmployeeを取得するREST API
   *
   * @param uuid 従業員UUID
   * @return EmployeeReadDto 従業員DTO
   */
  @GetMapping("{uuid}")
  public ResponseEntity<EmployeeReadDto> getByUuid(@PathVariable("uuid") String uuid) {
    EmployeeReadDto employeeReadDto = employeeService.getEmployeeByUuid(uuid);
    return ResponseEntity.ok().body(employeeReadDto);
  }
}
