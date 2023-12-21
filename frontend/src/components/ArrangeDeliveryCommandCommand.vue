<template>
    <v-card outlined>
        <v-card-title>
            ArrangeDeliveryCommand
        </v-card-title>

        <v-card-text>
            <Number label="OrderId" v-model="value.orderId" :editMode="editMode"/>
            <Address offline label="DeliveryAddress" v-model="value.deliveryAddress" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="arrangeDeliveryCommand"
            >
                ArrangeDeliveryCommand
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
        name: 'ArrangeDeliveryCommandCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.orderId = 0;
            this.value.deliveryAddress = {};
        },
        watch: {
        },
        methods: {
            arrangeDeliveryCommand() {
                this.$emit('arrangeDeliveryCommand', this.value);
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

