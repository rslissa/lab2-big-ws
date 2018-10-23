package translator.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import translator.Application;
import translator.domain.TranslatedText;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TranslatorServiceTest {

  @Autowired
  TranslatorService translatorService;

  @Test
  public void translateTest() {
    TranslatedText translatedText = translatorService.translate(
            "en", "es", "This is a test of translation service");
    assertEquals("Esto es una prueba de servicio de traducción", translatedText.getTranslation());
  }

  public void translateTest_Es_Fr() {
    TranslatedText translatedText = translatorService.translate(
            "es", "fr", "Esto es una prueba de servicio de traducción");
    assertEquals("Ceci est un test du service de traduction", translatedText.getTranslation());
  }
  public void translateTest_Fr_Es() {
    TranslatedText translatedText = translatorService.translate(
            "fr", "es", "Ceci est un test du service de traduction");
    assertEquals("Esto es una prueba de servicio de traducción", translatedText.getTranslation());
  }
}
