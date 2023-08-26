# frozen_string_literal: true

class CreateClientes < ActiveRecord::Migration[7.0]
  def change
    create_table :clientes do |t|
      t.string :nome
      t.text :endereco
      t.datetime :date_nascimento

      t.timestamps
    end
  end
end
