class ClientesController < ApplicationController
    before_action :find_cliente, only: :show

    def index
        @clientes = Cliente.all
        render json: @clientes
    end

    def show
        render json: @cliente
    end

    private

    def find_cliente
        @cliente = Cliente.find(params[:id])
    end
end