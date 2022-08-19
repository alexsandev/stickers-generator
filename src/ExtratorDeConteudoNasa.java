import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoNasa implements ExtratorDeConteudo {
    public List<Conteudo> extrair(String json){
        List<Map<String,String>> listaCrua = JsonParser.parse(json);
        List<Conteudo> conteudos = new ArrayList<Conteudo>();

        for (Map<String,String> map : listaCrua) {
            String title = map.get("title");
            String urlImage = map.get("url");
            conteudos.add(new Conteudo(title, urlImage));
        }
        return conteudos;
    }   
}
