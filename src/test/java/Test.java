import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by kahyalar on 07/02/2017.
 */
public class Test {
    WebDriver driver = new ChromeDriver();
    boolean dersAlındı = false;
    @org.junit.Test
    public void selectCourse() throws InterruptedException {
        driver.get("https://predator.bahcesehir.edu.tr/auth/login");
        driver.findElement(By.id("kullanici_adi")).sendKeys("leyla.bozkurt");
        driver.findElement(By.id("kullanici_sifre")).sendKeys("fb59cfc1");
        driver.findElement(By.xpath("//button[@class='btn btn-large btn-success shake']")).click();
        driver.findElement(By.xpath("//input")).click();
        driver.findElement(By.id("left-menu8")).click();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//nav[@id='sidr-left8']/a[3]")).click();
        dersiAl();
        while (!dersAlındı){
            if(!dersAlındı){
                driver.get("https://predator.bahcesehir.edu.tr/ogrenciler/derssecme/ogrindex");
                //driver.findElement(By.xpath("//div[@id='alert_modal']/div[3]/button")).click();
                dersiAl();
            }
            else {
                dersAlındı = true;
            }
        }
    }
    public void dersiAl() throws InterruptedException {
        driver.findElement(By.xpath("//table[@class='dersler table table-bordered table-striped']" +
                "[2]/tbody/tr[4]/td[6]/input")).click();
        Thread.sleep(2000);
        Set<String> set=driver.getWindowHandles();
        Iterator<String> popUp = set.iterator();
        String parent=popUp.next();
        String child=popUp.next();
        driver.switchTo().window(child);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//table/tbody/tr[7]/td[7]/input")).click();
        driver.switchTo().window(parent);
    }
}
