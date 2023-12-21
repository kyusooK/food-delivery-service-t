<template>
    <v-card outlined>
        <v-card-title>
            PlaceOrderCommand
        </v-card-title>

        <v-card-text>
            <List&lt;FoodItem&gt; offline label="FoodItems" v-model="value.foodItems" :editMode="editMode" @change="change"/>
            <FoodItemList offline label="FoodItems" v-model="value.foodItems" :editMode="editMode" @change="change"/>
            <int offline label="Quantity" v-model="value.quantity" :editMode="editMode" @change="change"/>
            <String label="SpecialRequests" v-model="value.specialRequests" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="placeOrderCommand"
            >
                PlaceOrderCommand
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'PlaceOrderCommandCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.foodItems = [];
            this.value.quantity = {};
            this.value.specialRequests = '';
        },
        watch: {
        },
        methods: {
            placeOrderCommand() {
                this.$emit('placeOrderCommand', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

