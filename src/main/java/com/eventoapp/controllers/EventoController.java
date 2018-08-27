package com.eventoapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eventoapp.models.Evento;
import com.eventoapp.repository.EventoRepository;


@Controller
public class EventoController {
	/*
	 * Após ter criado a interface, criamos a EventoRepositoy(nossa interface), 
	 * faremos também uma anotação, que será uma injeção de dependências, 
	 * toda vez que precisar utilizar a interface. será craido uma nova instância automáticamente
	 */
	@Autowired
	private EventoRepository er;
	/*
	 * também após a criação da interface
	 * vamos acrescentar um método para o nosso RequestMapping
	 * também na anotação requestMapping, temos a requisiçao que aponta para o valor cadastrarEvento
	 * que retorna o formulário html formEvento criado dentro da pasta evento
	 */
	@RequestMapping(value ="/cadastrarEvento", method=RequestMethod.GET)
	public String form(){
		return "evento/formEvento";
	}
	
	@RequestMapping(value ="/cadastrarEvento", method=RequestMethod.POST)
	public String form(Evento evento){
		//Assim ele vai salvar esse evento, no banco de dados
		er.save(evento);
		
		return "redirect:/cadastrarEvento";
	}
	
	@RequestMapping("/eventos")
	public ModelAndView listaEvento(){
		//O objeto do ModelAndView irá reinderizar a página index
		ModelAndView mv = new ModelAndView("index");
		//para criar uma busca de eventos
		Iterable<Evento> eventos = er.findAll();
		/*no mv adicionaremos 1 - objeto com atributo nome(o mesmo ${eventos}" que está na página index.html
		 *  e outro com o atributo valor, no caso a lista de eventos, para que seja mostrada a lista na view de
		 *  acordo com a lista que cadastramos no formulário
		 *  
		 */
		mv.addObject("evento", eventos);
		return mv;
		
	}
	
	@RequestMapping("/{codigo}")
	public ModelAndView detalhesEvento(@PathVariable("codigo") long codigo){
		//ele vai buscar o código específico  e guardar na variável evento
		//Evento evento = er.fyndByCodigo(codigo);
		ModelAndView mv = new ModelAndView("datalhesEvento");
		mv.addObject("evento", listaEvento());
		return mv;
	}
	

}
