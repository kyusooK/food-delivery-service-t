
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderServiceOrderManager from "./components/listers/OrderServiceOrderCards"
import OrderServiceOrderDetail from "./components/listers/OrderServiceOrderDetail"

import DeliveryServiceDeliveryManager from "./components/listers/DeliveryServiceDeliveryCards"
import DeliveryServiceDeliveryDetail from "./components/listers/DeliveryServiceDeliveryDetail"

import CustomerServiceCustomerSupportManager from "./components/listers/CustomerServiceCustomerSupportCards"
import CustomerServiceCustomerSupportDetail from "./components/listers/CustomerServiceCustomerSupportDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/orderServices/orders',
                name: 'OrderServiceOrderManager',
                component: OrderServiceOrderManager
            },
            {
                path: '/orderServices/orders/:id',
                name: 'OrderServiceOrderDetail',
                component: OrderServiceOrderDetail
            },

            {
                path: '/deliveryServices/deliveries',
                name: 'DeliveryServiceDeliveryManager',
                component: DeliveryServiceDeliveryManager
            },
            {
                path: '/deliveryServices/deliveries/:id',
                name: 'DeliveryServiceDeliveryDetail',
                component: DeliveryServiceDeliveryDetail
            },

            {
                path: '/customerServices/customerSupports',
                name: 'CustomerServiceCustomerSupportManager',
                component: CustomerServiceCustomerSupportManager
            },
            {
                path: '/customerServices/customerSupports/:id',
                name: 'CustomerServiceCustomerSupportDetail',
                component: CustomerServiceCustomerSupportDetail
            },



    ]
})
