package br.com.simulator;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Simulator {

  private static Robot robot;

  public static void main(String[] args) throws Exception {
    robot = new Robot();

    String text = "import.com.smartlead.common.utils.DateUtils;"
        + "import.com.smartlead.mct.context.metaData.dataAcceptance.APIDAContext;"
        + "import.com.smartlead.mct.domain.dto.metaData.dc.MessagesVariableEnum;"
        + "import.com.smartlead.mct.service.DAResponseService;"
        + "import.com.smartlead.mct.service.metaData.dataAcceptance.MessagesService;"
        + "import.com.smartlead.mct.util.ETLUtil;"
        + "import.com.smartlead.mct.util.SLSUtilMCT;"
        + "import.com.smartlead.mct.util.metaData.DataAcceptanceUtil;"
        + "import.com.smartleads.lpsdb.domain.enums.metaData.dp.DataProviderMediumTypeEnum;"
        + "import.com.smartleads.lpsdb.domain.metaData.bidirectional.InDataConnector;"
        + "import.com.smartleads.lpsdb.domain.metaData.bidirectional.InDataConnectorMessageTypeMapping;"
        + "import.com.smartleads.lpsdb.domain.metaData.dc.DataConsumer;"
        + "import.com.smartleads.lpsdb.domain.metaData.dp.DataProvider;"
        + "import.com.smartleads.lpsdb.domain.response.LPSResponse;"
        + "import.com.smartleads.lpsdb.domain.response.LPSResponseCode;"
        + "import.java.time.LocalDateTime;"
        + "import.java.time.ZoneId;"
        + "import.java.util.Date;"
        + "import.java.util.List;"
        + "import.javax.servlet.http.HttpServletRequest;"
        + "import.org.apache.commons.collections.CollectionUtils;"
        + "import.org.apache.commons.lang3.StringUtils;"
        + "import.org.apache.logging.log4j.LogManager;"
        + "import.org.apache.logging.log4j.Logger;"
        + "import.org.springframework.http.HttpHeaders;"
        + "import.org.springframework.http.HttpStatus;"
        + "import.org.springframework.http.MediaType;"
        + "import.org.springframework.http.ResponseEntity;"
        + "import.org.springframework.web.bind.ServletRequestBindingException;"
        + "import.com.smartleads.cache.CacheManagementService;"
        + "import.com.smartleads.cache.api.CacheManager;"
        + "import.com.smartleads.common.TransactionManagerNames;"
        + "import.com.smartleads.lms.domain.dto.tmc.LmsLead;"
        + "import.com.smartleads.lms.services.tmc.LeadApiService;"
        + "import.com.smartleads.lmsdb.domain.addon.Addon;"
        + "import.com.smartleads.lmsdb.domain.addon.AddonLeadMapping;"
        + "import.com.smartleads.lmsdb.domain.addon.AddonPendingLead;"
        + "import.com.smartleads.lmsdb.domain.enums.AddonDealerState;"
        + "import.com.smartleads.lmsdb.domain.enums.AddonPricingModel;"
        + "import.com.smartleads.lmsdb.repository.OemProgramRepository;"
        + "import.com.smartleads.lmsdb.repository.addon.AddonDealerStateHistoryRepository;"
        + "import.com.smartleads.lmsdb.repository.addon.AddonLeadMappingRepository;"
        + "import.com.smartleads.lmsdb.repository.addon.AddonPendingLeadRepository;"
        + "import.com.smartleads.lmsdb.repository.addon.AddonProgramMappingRepository;"
        + "import.com.smartleads.lmsdb.repository.addon.AddonRepository;"
        + "import.com.smartleads.lmsdb.repository.util.HibernateUtil;"
        + "import.java.math.BigDecimal;"
        + "import.java.util.ArrayList;"
        + "import.java.util.Arrays;"
        + "import.java.util.Collections;"
        + "import.java.util.HashMap;"
        + "import.java.util.Map;"
        + "import.java.util.Map.Entry;"
        + "import.java.util.Optional;"
        + "import.java.util.concurrent.ConcurrentHashMap;"
        + "import.lombok.extern.log4j.Log4j2;"
        + "import.org.apache.commons.collections4.CollectionUtils;"
        + "import.org.springframework.beans.factory.annotation.Autowired;"
        + "import.org.springframework.context.ApplicationContext;"
        + "import.org.springframework.stereotype.Service;"
        + "import.org.springframework.transaction.annotation.Transactional;";

    boolean running = true;
    while (running) {
      mouseEvents();

      Thread.sleep(1000);

      keyboardEvents(text);

      System.out.println("Finish");
      Thread.sleep(360000);
    }

  }

  private static void mouseEvents() {
    int numberOfClicks = new Random().nextInt(100) + 80;
    System.out.println("---Clicks:" + numberOfClicks);
    for (int i = 0; i < numberOfClicks; i++) {
      int x = new Random().nextInt(10) + 80;
      int y = new Random().nextInt(90) + 400;
      click(x, y);
      System.out.println("X: " + x + " Y: " + y);
    }

  }

  private static void click(int x, int y) {

    robot.mouseMove(x, y);
    robot.delay(50);
    robot.mousePress(MouseEvent.BUTTON1_MASK);
    robot.mouseRelease(MouseEvent.BUTTON1_MASK);

  }

  private static void keyboardEvents(String text) {
    for (int rep = 0; rep < (new Random().nextInt(3) + 1); rep++) {

      String toPring = "";
      String[] arryOfWords = text.split("\\.");
      while (toPring.length() < 150) {
        toPring += arryOfWords[new Random().nextInt(arryOfWords.length -1)] + " ";
      }
      toPring += "\n";

      char[] textCaps = toPring.toUpperCase().toCharArray();

      robot.keyPress(KeyEvent.VK_SLASH);
      robot.keyRelease(KeyEvent.VK_SLASH);
      robot.keyPress(KeyEvent.VK_SLASH);
      robot.keyRelease(KeyEvent.VK_SLASH);

      for (char c : textCaps) {
        if (text.indexOf(c) == 0) {
          robot.keyPress(KeyEvent.VK_SHIFT);
        }
        robot.keyPress(c);
        robot.keyRelease(c);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.delay(10);
        System.out.print(c);
      }
    }
  }
}
