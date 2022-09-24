package ar.org.centro8.curso.java;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.org.centro8.curso.java.data.services.ArticuloDataService;
import ar.org.centro8.curso.java.data.services.ClienteDataService;
import ar.org.centro8.curso.java.entities.Articulo;
import ar.org.centro8.curso.java.entities.Cliente;
import ar.org.centro8.curso.java.enums.EstadoCivil;
import ar.org.centro8.curso.java.enums.Rubro;

@Controller
public class ControllerWeb{
	private String mensaje ="Ingrese un nuevo cliente!";
	private String mensajeArt="Ingrese un nuevo articulo!";
	@Autowired
	private ClienteDataService clienteService;
	@Autowired
	private ArticuloDataService artService;
	@GetMapping("/")
	public String index(@RequestParam(name="nombre", required=false, defaultValue="World") String nombre,Model model){
		model.addAttribute("nombre",nombre);
		return "index";
	}

    @GetMapping("/clientes")
	public String clientes(@RequestParam(name="buscarApellido", required=false, defaultValue="") String buscarApellido, Model model){
		model.addAttribute("estados", List.of(EstadoCivil.values()));
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("mensajeInfo", mensaje);
		model.addAttribute("all", clienteService.getAll());
		model.addAttribute("likeApellido", clienteService.getLikeApellido(buscarApellido));
		return "clientes";
	}
 
    @GetMapping("/articulos")
	public String articulos(@RequestParam(name = "buscarRubro",required = false, defaultValue = "BEBIDAS")String buscarRubro, Model model)
	{
		model.addAttribute("rubros", List.of(Rubro.values()));
		model.addAttribute("articulo", new Articulo());
		model.addAttribute("mensajeInfoArt", mensajeArt);
		model.addAttribute("byRubro", artService.getByRubro(buscarRubro));
		model.addAttribute("all", artService.getAll());
		return "articulos";
	}

    @GetMapping("/facturas")
	public String facturas(Model model){
		return "facturas";
	}

	@PostMapping("/saveCliente")
	public String saveCliente(@ModelAttribute Cliente cliente){
		System.out.println("*****************************************************");
		System.out.println(cliente);
		System.out.println("*****************************************************");
		try{
			clienteService.save(cliente);
			mensaje="Se ingreso un nuevo cliente id: "+cliente.getId();
		}catch(Exception e){
			mensaje="Ocurrio un error!";
		}
		return "redirect:clientes";
	}

	@PostMapping("/saveArticulo")
	public String saveArticulo(@ModelAttribute Articulo articulo){
		System.out.println("*****************************************************");
		System.out.println(articulo);
		System.out.println("*****************************************************");
		try {
			artService.save(articulo);
			mensajeArt="Se ingreso un nuevo articulo id: "+articulo.getId();
		} catch (Exception e) {
			mensajeArt="Ocurrio un error!";
		}
		return "redirect:articulos";
	}



}