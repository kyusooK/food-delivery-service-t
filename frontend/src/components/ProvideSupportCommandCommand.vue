<template>
    <v-card outlined>
        <v-card-title>
            ProvideSupportCommand
        </v-card-title>

        <v-card-text>
            <UUID offline label="OrderId" v-model="value.orderId" :editMode="editMode" @change="change"/>
            <String label="SupportMessage" v-model="value.supportMessage" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="provideSupportCommand"
            >
                ProvideSupportCommand
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
        name: 'ProvideSupportCommandCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.orderId = {};
            this.value.supportMessage = '';
        },
        watch: {
        },
        methods: {
            provideSupportCommand() {
                this.$emit('provideSupportCommand', this.value);
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

