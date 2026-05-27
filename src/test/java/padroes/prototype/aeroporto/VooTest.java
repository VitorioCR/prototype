package padroes.prototype.aeroporto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VooTest {

    private Terminal terminal;
    private Voo vooOriginal;

    @BeforeEach
    void setUp() {
        terminal = new Terminal("Terminal 1", 10);
        vooOriginal = new Voo("G31234", "Buenos Aires (EZE)", terminal, "GOL");
    }

    // --- clone() ---

    @Test
    void clonarVooCriaNovoObjeto() throws CloneNotSupportedException {
        Voo clone = vooOriginal.clone();
        assertNotSame(vooOriginal, clone, "Clone deve ser um objeto diferente do original");
    }

    @Test
    void clonarVooCopiaDadosPrimitivos() throws CloneNotSupportedException {
        Voo clone = vooOriginal.clone();
        assertEquals(vooOriginal.getCodigo(), clone.getCodigo());
        assertEquals(vooOriginal.getDestino(), clone.getDestino());
        assertEquals(vooOriginal.getCompanhia(), clone.getCompanhia());
    }

    @Test
    void clonarVooFazDeepCopyDoTerminal() throws CloneNotSupportedException {
        Voo clone = vooOriginal.clone();
        assertNotSame(vooOriginal.getTerminal(), clone.getTerminal(),
                "Terminal do clone deve ser uma instância diferente (deep copy)");
    }

    @Test
    void alterarTerminalDoCloneNaoAfetaOriginal() throws CloneNotSupportedException {
        Voo clone = vooOriginal.clone();
        clone.getTerminal().setPortao(99);
        assertEquals(10, vooOriginal.getTerminal().getPortao(),
                "Portão do original não deve ser alterado após mudar o clone");
    }

    @Test
    void alterarCodigoDoCloneNaoAfetaOriginal() throws CloneNotSupportedException {
        Voo clone = vooOriginal.clone();
        clone.setCodigo("AA9999");
        assertEquals("G31234", vooOriginal.getCodigo(),
                "Código do original não deve ser alterado");
    }

    // --- Terminal clone ---

    @Test
    void clonarTerminalCriaNovoObjeto() throws CloneNotSupportedException {
        Terminal clone = (Terminal) terminal.clone();
        assertNotSame(terminal, clone);
    }

    @Test
    void clonarTerminalCopiaDados() throws CloneNotSupportedException {
        Terminal clone = (Terminal) terminal.clone();
        assertEquals(terminal.getNome(), clone.getNome());
        assertEquals(terminal.getPortao(), clone.getPortao());
    }

    // --- getters / setters ---

    @Test
    void setterDeCodigoAlteraValor() {
        vooOriginal.setCodigo("LA0001");
        assertEquals("LA0001", vooOriginal.getCodigo());
    }

    @Test
    void setterDeDestinoAlteraValor() {
        vooOriginal.setDestino("Lisboa (LIS)");
        assertEquals("Lisboa (LIS)", vooOriginal.getDestino());
    }

    @Test
    void setterDeCompanhiaAlteraValor() {
        vooOriginal.setCompanhia("TAP");
        assertEquals("TAP", vooOriginal.getCompanhia());
    }

    @Test
    void setterDeTerminalAlteraReferencia() {
        Terminal novoTerminal = new Terminal("Terminal 3", 5);
        vooOriginal.setTerminal(novoTerminal);
        assertSame(novoTerminal, vooOriginal.getTerminal());
    }

    // --- toString ---

    @Test
    void toStringDeVooContemCampos() {
        String str = vooOriginal.toString();
        assertTrue(str.contains("G31234"));
        assertTrue(str.contains("Buenos Aires (EZE)"));
        assertTrue(str.contains("GOL"));
    }

    @Test
    void toStringDeTerminalContemCampos() {
        String str = terminal.toString();
        assertTrue(str.contains("Terminal 1"));
        assertTrue(str.contains("10"));
    }
}
