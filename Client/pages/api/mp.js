// SDK de Mercado Pago
const mercadopago = require('mercadopago')
// Agrega credenciales
mercadopago.configure({
  access_token:
    'TEST-2692948327591240-030223-cc2ec07a577b7ad962f746e6cdace6d5-559348681',
})

// Crea un objeto de preferencia
let preference = {
  collector_id: 202809963,
  items: [
    {
      title: 'Dummy Item',
      description: 'Multicolor Item',
      currency_id: '$',
      quantity: 1,
      unit_price: 10,
    },
  ],
  payer: {
    phone: {},
    identification: {},
    address: {},
  },
  back_urls: {
    success: 'http://localhost:3000/checkout',
  },
  payment_methods: {
    excluded_payment_methods: [{}],
    excluded_payment_types: [{}],
  },
  client_id: 6295877106812064,
  marketplace: 'MP-MKT-6295877106812064',
  marketplace_fee: 0,
  shipments: {
    receiver_address: {},
  },
  statement_descriptor: 'MERCADOPAGO',
  date_created: '2018-02-02T19:22:23.535Z',
  id: '202809963-920c288b-4ebb-40be-966f-700250fa5370',
  init_point:
    'https://www.mercadopago.com/mla/checkout/start?pref_id=202809963-920c288b-4ebb-40be-966f-700250fa5370',
  sandbox_init_point:
    'https://sandbox.mercadopago.com/mla/checkout/pay?pref_id=202809963-920c288b-4ebb-40be-966f-700250fa5370',
  metadata: {},
}

const Checkout = async (preference) => {
  await mercadopago.preferences
    .create(preference)
    .then((res) => {
      console.log(res)
      // En esta instancia deberás asignar el valor dentro de response.body.id por el ID de preferencia solicitado en el siguiente paso
    })
    .catch((error) => {
      console.log(error)
    })
}
