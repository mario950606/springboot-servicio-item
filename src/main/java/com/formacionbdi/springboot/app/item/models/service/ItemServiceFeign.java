package com.formacionbdi.springboot.app.item.models.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.formacionbdi.springboot.app.commons.models.entity.Producto;
import com.formacionbdi.springboot.app.item.clientes.ProductoClienteRest;
import com.formacionbdi.springboot.app.item.models.Item;

@Service("ItemServiceFeign" )
@Primary
public class ItemServiceFeign implements ItemService {

	@Autowired
	private ProductoClienteRest clienteFeign;
	
	@Override
	public List<Item> findAll() {
		// TODO Auto-generated method stub
		return clienteFeign.listar().stream().map(p-> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		// TODO Auto-generated method stub
		return new Item(clienteFeign.detalle(id), cantidad);
	}

	@Override
	public Producto save(Producto producto) {
		// TODO Auto-generated method stub
		return clienteFeign.crear(producto);
	}

	@Override
	public Producto update(Producto producto, Long id) {
		// TODO Auto-generated method stub
		return clienteFeign.update(producto, id);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		clienteFeign.eliminar(id);
	}

}
