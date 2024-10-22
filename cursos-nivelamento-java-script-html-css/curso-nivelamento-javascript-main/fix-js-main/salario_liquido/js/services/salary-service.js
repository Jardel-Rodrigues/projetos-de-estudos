import * as taxService from './tax-service';
import * as pensionService from './pension-service';

export function netSalary(employee){
    const tax = taxService.tax(employee.grossSalary);
    const pension = pensionService.discount(employee.grossSalary);
    return employee.grossSalary - tex - pension;
}