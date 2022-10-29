import datawork as dt


t = f"""Homens da pesquisa: {dt.get_total_male()}
    Mulheres da pesquisa: {dt.get_total_female()} 

    Homens casados: {dt.get_married_male()}
    Mulheres casadas: {dt.get_married_female()}

    Homens graduados: {dt.get_graduate_man()}
    Mulheres graduadas: {dt.get_graduate_women()}

    Pessoas casadas graduadas: {dt.get_married_graduate()}
    Pessoas não-casadas graduadas: {dt.get_married_not_graduate() } 

    Pessoas casadas na zona Urbana por população (%): {dt.get_percent_married_urban() }%
    Pessoas casadas na zona Rural por população total (%): {dt.get_percent_married_rural() }%
    Pessoas casadas na zona Semirural por população total(%) : {dt.get_percent_married_semiurban()}% """


print(t)
