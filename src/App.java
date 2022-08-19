import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import javax.imageio.IIOException;

public class App {

    public static void main(String[] args) throws Exception {

        BufferedReader arquivo = new BufferedReader(new FileReader("src/endpoint.properties"));
        String url = arquivo.readLine();
        String json = ClientHttp.buscar(url);

        ExtratorDeConteudo extrator = new ExtratorDeConteudoIMDB();
        List<Conteudo> conteudos = extrator.extrair(json);
        //ExtratorDeConteudo extrator = new ExtratorDeConteudoNasa();
        //List<Conteudo> conteudos = extrator.extrair(json);

       
            for (Conteudo conteudo : conteudos) {
                try{
                    String nomeArquivo = conteudo.getTitle();
                    InputStream inputStream = new URL(conteudo.getUrlImage()).openStream();
                    StickerGenerator.cria(inputStream, nomeArquivo);
                    System.out.println(nomeArquivo);
                }catch (FileNotFoundException | IIOException exception){
                    System.out.println("FILE NOT FOUND:" + conteudo.getTitle());
                }
            }
        
        arquivo.close();
    }
}
