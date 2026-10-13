
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PendaftaranValidatorTest {

    private final PendaftaranValidator validator =
            new PendaftaranValidator();

    @Test
    public void testNamaKosong() {
        assertEquals(
                "Nama harus diisi",
                validator.validasiPendaftaran(
                        "", 20, "zahra@gmail.com", true
                )
        );
    }

    @Test
    public void testUmurKurangDari17() {
        assertEquals(
                "Umur minimal 17 tahun",
                validator.validasiPendaftaran(
                        "Zahra", 16, "zahra@gmail.com", true
                )
        );
    }

    @Test
    public void testEmailTidakValid() {
        assertEquals(
                "Email tidak valid",
                validator.validasiPendaftaran(
                        "Zahra", 20, "zahragmail.com", true
                )
        );
    }

    @Test
    public void testBelumSetujuSyarat() {
        assertEquals(
                "Harus menyetujui syarat dan ketentuan",
                validator.validasiPendaftaran(
                        "Zahra", 20, "zahra@gmail.com", false
                )
        );
    }

    @Test
    public void testPendaftaranBerhasil() {
        assertEquals(
                "Pendaftaran berhasil",
                validator.validasiPendaftaran(
                        "Zahra", 20, "zahra@gmail.com", true
                )
        );
    }
}
