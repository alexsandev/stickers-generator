import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoIMDB implements ExtratorDeConteudo {
    public List<Conteudo> extrair(String json){
        List<Map<String,String>> listaCrua = JsonParser.parse(json);
        List<Conteudo> conteudos = new ArrayList<Conteudo>();

        for (Map<String,String> map : listaCrua) {
            String title = map.get("title");
            String urlImage = map.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg");
            conteudos.add(new Conteudo(title, urlImage));
        }
        return conteudos;
    }   
}

