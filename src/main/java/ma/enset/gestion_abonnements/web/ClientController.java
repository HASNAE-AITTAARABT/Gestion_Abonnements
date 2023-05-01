package ma.enset.gestion_abonnements.web;

import lombok.AllArgsConstructor;
import ma.enset.gestion_abonnements.entities.Client;
import ma.enset.gestion_abonnements.repositories.ClientRepository;
import ma.enset.gestion_abonnements.services.ClientServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class ClientController {
    ClientServiceImpl clientService;
    ClientRepository clientRepository ;
    @GetMapping(path = "/index")
    public String clientsList(Model model, @RequestParam(name = "page",defaultValue = "0") int page , @RequestParam(name = "size",defaultValue = "5") int size, @RequestParam(name = "keyword",defaultValue = "") String keyword) {
        Page<Client> clientsList =  clientRepository.findByNomContains(keyword, PageRequest.of(page,size));
        model.addAttribute("clientsList",clientsList.getContent());
        model.addAttribute("totalPages",new int[clientsList.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);
        return "clients";
    }
    @GetMapping(path = "/delete")
    public String delete(@RequestParam(name = "id") Long  id, @RequestParam(name = "page",defaultValue = "0") int page,@RequestParam(name = "keyword",defaultValue = "") String keyword){
        clientService.deleteClient(id);
        return "redirect:/index?page="+page+"&keyword="+keyword+"";
    }
    @GetMapping(path = "/")
    public String Default(){
        return "redirect:/index";
    }
}
