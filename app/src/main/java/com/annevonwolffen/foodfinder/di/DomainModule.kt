package com.annevonwolffen.foodfinder.di

import com.annevonwolffen.foodfinder.domain.RecipesSearchInteractor
import com.annevonwolffen.foodfinder.domain.RecipesSearchInteractorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface DomainModule {

    @Binds
    fun bindRecipesSearchInteractor(interactor: RecipesSearchInteractorImpl) : RecipesSearchInteractor
}