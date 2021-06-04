package sample;

import java.util.*;
/** implements the SalaryCard extending Card
 *
 *
 */
public class SalaryCard extends Card {

    private int salary;
    private int taxDue;

    public SalaryCard() {}

    public int getSalary() {
        return this.salary;
    }

    public void setSalary(int amt) {
        this.salary = amt;
    }

    public int getTaxDue() {
        return this.taxDue;
    }

    public void setTaxDue (int amt) {
        this.taxDue = amt;
    }
    /** implements the SalaryCard extending Card
     *
     * @return int amount of generated  salary
     */
    public int generateMaxMultipleSalary() {
        Random random = new Random();

        return random.nextInt() * 10000;
    }
    /** implements the SalaryCard extending Card
     *
     * @return int amount of generated tax
     */
    public int generateMaxMultipleTax() {
        Random random = new Random();

        return random.nextInt() * 1000;
    }
}