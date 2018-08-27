package com.eventoapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.eventoapp.models.Evento;

/*Com esta interface poderemos usar métodos já prontos para dar update, delete, inset, entre outros
 * no banco de dados e aqui emabixo definimos a entidade a ser utilizada  
 */
public interface EventoRepository extends CrudRepository<Evento, String> {
	//aqui é pra chamar um evento específico, como detalhe do evento
	//Evento fyndByCodigo(long codigo);

}
