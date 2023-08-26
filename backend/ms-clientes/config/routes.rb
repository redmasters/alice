Rails.application.routes.draw do
  scope :api do
      resources :clientes
  end
end