package vidyamanager.com.vidyamanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vidyamanager.com.vidyamanager.model.Produto;
import vidyamanager.com.vidyamanager.repository.ProdutoRepository;

import java.util.List;

@Controller
@RestController
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping(value = "salvarProduto") /* mapeia a url */
    @ResponseBody /* Descricao da resposta */
    public ResponseEntity<Produto> salvar(@RequestBody Produto produto) { /* Recebe os dados para salvar */

        Produto produto1 = produtoRepository.save(produto);

        return new ResponseEntity<Produto>(produto1, HttpStatus.CREATED);

    }

    @PostMapping(value = "listatodosProdutos") /* Nosso primeiro método de API */
    @ResponseBody /* Retorna os dados par ao corpo da resposta */
    public ResponseEntity<List<Produto>> listprod() {

        List<Produto> produtos = (List<Produto>) produtoRepository.findAll();/* executa a consulta no banco de dados */

        return new ResponseEntity<List<Produto>>(produtos, HttpStatus.OK);/* Retorna a lista em JSON */

    }


}
